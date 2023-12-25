package Service;
public interface ZGenericService<T> {
    String add(Long  hospitalId, T t);

    void removeById(Long id);

    String updateById(Long id, T t);
}
