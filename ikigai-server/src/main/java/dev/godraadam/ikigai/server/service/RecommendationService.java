package dev.godraadam.ikigai.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import dev.godraadam.ikigai.server.model.User;
import dev.godraadam.ikigai.server.model.Visit;
import dev.godraadam.ikigai.server.repo.UserRepository;

public class RecommendationService {

    private User user;
    
    @Autowired
    private UserRepository userRepository;

    private static int commonCountryThreshold = 3;

    public RecommendationService(User user) {
        this.user = user;
    }

    private List<User> findSimilarUsers() {
        //definition of similarity: share as many visited countries they both visited
        List<User> similarUsers;
        Iterable<User> allUsers = userRepository.findAll();
        Map<User, Integer> commonCountryCount = new TreeMap<>();
        for (Visit visit : user.getVisits()) {
            for (User otherUser : allUsers) {
                for (Visit otherVisit : otherUser.getVisits()) {
                    if (visit.getCountry() == otherVisit.getCountry() && user != otherUser) {
                        if (commonCountryCount.get(otherUser) == null) {
                            commonCountryCount.put(otherUser, 0);
                        }
                        else {
                            commonCountryCount.put(otherUser, commonCountryCount.get(otherUser) + 1);
                        }
                    }
                }
            }
        }

        similarUsers = commonCountryCount.keySet().stream().filter(key -> commonCountryCount.get(key) >= commonCountryThreshold).collect(Collectors.toList());
        System.out.println(similarUsers);
        return similarUsers;
    }

    public List<String> getRecommendedCountries() {
        List<User> similarUsers = findSimilarUsers();
        List<String> countries = user.getVisits().stream().map(visit -> visit.getCountry()).collect(Collectors.toList());
        List<String> possibleCountries = new ArrayList<>();
        for (User otherUser : similarUsers) {
            for (Visit visit : otherUser.getVisits()) {
                if (!countries.contains(visit.getCountry())) {
                    possibleCountries.add(visit.getCountry());
                }
            }
        }

        return possibleCountries;
    }
    
}
