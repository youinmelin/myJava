package lin.dao;

import lin.domain.Items;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemsDao {

    @Select("select * from items where id = #{id}")
    Items findItemById(Integer id);
}
