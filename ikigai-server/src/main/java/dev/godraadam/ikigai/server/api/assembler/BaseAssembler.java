package dev.godraadam.ikigai.server.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import dev.godraadam.ikigai.common.dto.BaseDTO;
import dev.godraadam.ikigai.server.model.BaseModel;

public interface BaseAssembler<M extends BaseModel, D extends BaseDTO> {

    D createDto(M m);

	M createModel(D d);

	M updateModel(M m, D d);

	default List<M> createModelList(final List<D> ds) {
		if (ds != null) {
			return ds.stream().map(this::createModel).collect(Collectors.toList());
		} else {
			return null;
		}
	}

	default List<D> createDTOList(final List<M> ms) {
		if (ms != null) {
			return ms.stream().map(this::createDto).collect(Collectors.toList());
		} else {
			return null;
		}
	}
}
