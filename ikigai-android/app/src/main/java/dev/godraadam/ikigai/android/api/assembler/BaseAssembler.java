package dev.godraadam.ikigai.android.api.assembler;

import java.util.List;

public interface BaseAssembler<M, D> {

    M createModel(D d);

    M updateModel(M m, D d);

    default D createDto(M m) {
        return null;
    }

    List<M> createModelList(final List<D> ds);

    default List<D> createDtoList(final List<M> ms) {
        return null;
    }
}