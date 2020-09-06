package com.example.demo.repository;

import com.example.demo.entity.Clothes;
import com.example.demo.entity.ClothesResult;
import com.example.demo.entity.OrderResult;
import com.example.demo.entity.Ordergoods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sun.awt.SunHints;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Repository
public interface OrdergoodsRepository extends JpaRepository<Ordergoods,Integer> {
//    @Query(value = "select ordergoods.id,buliao.price,style.styles ,color.colors,buliao.materials,ordergoods.sex,ordergoods.size,ordergoods.clothes,ordergoods.state,ordergoods.remarks,ordergoods.make from ordergoods,color,buliao,style WHERE ordergoods.cid=color.id and ordergoods.bid=buliao.id and ordergoods.sid=style.id",nativeQuery = true)
@Query(value = "select ordergoods.id as id ,buliao.price as price,style.styles as styles ,color.colors as colors,buliao.materials as materials,ordergoods.sex as sex,ordergoods.size as size,ordergoods.clothes as clothes,ordergoods.state as state,ordergoods.remarks as remarks,ordergoods.make as make from ordergoods,color,buliao,style WHERE ordergoods.cid=color.id and ordergoods.bid=buliao.id and ordergoods.sid=style.id",nativeQuery = true)
public List<OrderResult> findres();

    @Query(value = "select * from ordergoods where uid=?",nativeQuery = true)
    public List<Ordergoods> findbywid(@Param("uid") int uid);

    @Query(value = "select ordergoods.id as id ,buliao.price as price,style.styles as styles ,color.colors as colors,buliao.materials as materials,ordergoods.sex as sex,ordergoods.size as size,ordergoods.clothes as clothes,ordergoods.state as state,ordergoods.remarks as remarks,ordergoods.make as make from ordergoods,color,buliao,style WHERE ordergoods.cid=color.id and ordergoods.bid=buliao.id and ordergoods.sid=style.id order by ordergoods.id ",nativeQuery = true)
    public Page<OrderResult> findpage(Pageable pageable);

    @Query(value = "select ordergoods.id as id ,buliao.price as price,style.styles as styles ,color.colors as colors,buliao.materials as materials,ordergoods.sex as sex,ordergoods.size as size,ordergoods.clothes as clothes,ordergoods.state as state,ordergoods.remarks as remarks,ordergoods.make as make from ordergoods,color,buliao,style WHERE ordergoods.cid=color.id and ordergoods.bid=buliao.id and ordergoods.sid=style.id and ordergoods.uid=?",nativeQuery = true)
    public List<OrderResult> findpersonal(@Param("uid") Integer id);

    @Query(value = "select ordergoods.id as id ,buliao.price as price,style.styles as styles ,color.colors as colors,buliao.materials as materials,ordergoods.sex as sex,ordergoods.size as size,ordergoods.clothes as clothes,ordergoods.state as state,ordergoods.remarks as remarks,ordergoods.make as make from ordergoods,color,buliao,style WHERE ordergoods.cid=color.id and ordergoods.bid=buliao.id and ordergoods.sid=style.id and ordergoods.id=?",nativeQuery = true)
    public OrderResult findbyid(@Param("id") Integer id);

    @Query(value = "select uid from ordergoods where id=?",nativeQuery = true)
    public Integer finduid(@Param("id") Integer id);

    @Query(value = "select ordergoods.id as id ,buliao.price as price,style.styles as styles ,color.colors as colors,buliao.materials as materials,ordergoods.sex as sex,ordergoods.size as size,ordergoods.clothes as clothes,ordergoods.state as state,ordergoods.remarks as remarks,ordergoods.make as make from ordergoods,color,buliao,style WHERE ordergoods.cid=color.id and ordergoods.bid=buliao.id and ordergoods.sid=style.id and make=?",nativeQuery = true)
    public List<OrderResult> findmake(@Param("make") String make);
}
