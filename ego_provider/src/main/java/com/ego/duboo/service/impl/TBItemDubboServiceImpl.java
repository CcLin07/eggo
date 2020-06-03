package com.ego.duboo.service.impl;

import com.ego.commons.pojo.exception.DaoException;
import com.ego.dubbo.service.TBItemDubboService;
import com.ego.mapper.TbItemMapper;
import com.ego.pojo.TbItem;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 商品操作
 * @Service 表示把当前类实现的接口发布到zookeepr中  这里使用apache的
 * @author Lin
 */
@Service
public class TBItemDubboServiceImpl implements TBItemDubboService {

    @Autowired
    private TbItemMapper tbItemMapper;
    /**
     * 商品查询
     * @param pageSize  每页大小
     * @param pageNumber 页码
     * @return 总条数
     */
    @Override
    public List<TbItem> selectByPage(int pageSize, int pageNumber) {
       //设置分页 分页插件要在查询之上否则无效
        PageHelper.startPage(pageNumber,pageSize);

        //Example 相当于sql中的where 这里使用的是select * from tb_item limit ? ,?
        //没有where给个null
        List<TbItem> list = tbItemMapper.selectByExample(null);
        //不要忘记构造方法参数
        PageInfo<TbItem> pi = new PageInfo<>(list);
        return pi.getList();
    }

    /**
     * 商品总条数查询
     * @return 总条数
     */
    @Override
    public long selectCount() {
        //Example 相当于sql中的where 这里使用的是select * from tb_item limit ? ,?
        //没有where给个null
        return tbItemMapper.countByExample(null);
    }

    @Override
    @Transactional
    public int updateStatusByIds(long[] ids, byte status) throws DaoException{
        int flag =0;
        for (long id : ids) {
            TbItem tbItem = new TbItem();
            tbItem.setId(id);
            tbItem.setStatus(status);
            tbItem.setUpdated(new Date());
           flag+=tbItemMapper.updateByPrimaryKeySelective(tbItem);
        }
        if (flag == ids.length){//如果修改的条数和数组的长度一致表示修改成功
            return 1;
        }throw new DaoException("批量修改失败");
    }


}
