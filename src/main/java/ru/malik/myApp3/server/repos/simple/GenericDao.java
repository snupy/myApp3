package ru.malik.myApp3.server.repos.simple;

import com.sencha.gxt.data.shared.SortInfo;
import com.sencha.gxt.data.shared.loader.FilterConfig;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Малик on 04.11.2014.
 */
public interface GenericDao <T, PK extends Serializable> {

    /** Сохранить объект newInstance в базе данных */
    PK create(T newInstance);

    /** Извлечь объект, предварительно сохраненный в базе данных, используя
     *   указанный id в качестве первичного ключа
     */
    T read(PK id);

    /** Сохранить изменения, сделанные в объекте.  */
    void update(T transientObject);

    /** Сохранить изменения, сделанные в объекте.  */
    void saveOrUpdate(T transientObject);

    /** Удалить объект из базы данных */
    void delete(T persistentObject);

    /**
     * Получить все обекты из БД
     * @return все обекты
     */
    List<T> getAll();

    List<T> getAll(int start, int range);
    List<T> getAll(int start, int range, List<? extends SortInfo> sortInfo, List<? extends FilterConfig> filterConfig);
    Long count();
}