package com.real.o2o.dao;

import com.real.o2o.entity.Award;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: mabin
 * @create: 2019/5/5 17:31
 */
public interface AwardDao {

    /**
     * 根据传入的条件分页显示奖品信息列表
     * @param awardCondition
     * @param rowIndex
     * @param pageSize
     * @return
     */
    List<Award> queryAwardList(@Param("awardCondition") Award awardCondition, @Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize);

    /**
     * 配合queryAwardList返回相同查询条件下奖品的总数
     * @param awardCondition
     * @return
     */
    int queryAwardCount(@Param("awardCondition") Award awardCondition);

    /**
     * 通过awardId查询奖品信息
     * @param awardId
     * @return
     */
    Award queryAwardById(long awardId);

    /**
     * 添加奖品信息
     * @param award
     * @return
     */
    int insertAward(Award award);

    /**
     * 更新奖品信息
     * @param award
     * @return
     */
    int updateAward(Award award);

    /**
     * 删除奖品信息
     * @param awardId
     * @param shopId
     * @return
     */
    int deleteAward(@Param("awardId") long awardId, @Param("shopId") long shopId);
}
