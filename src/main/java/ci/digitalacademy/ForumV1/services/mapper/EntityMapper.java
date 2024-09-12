package ci.digitalacademy.ForumV1.services.mapper;

public interface EntityMapper<D, T> {

    T toEntity(D d);

    D toDto(T t);
}
