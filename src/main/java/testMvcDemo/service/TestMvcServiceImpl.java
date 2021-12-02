package testMvcDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testMvcDemo.dao.TestMvcMapper;
import testMvcDemo.domain.Item;

@Service
@Transactional
public class TestMvcServiceImpl implements  TestMvcService{

   @Autowired
   TestMvcMapper testMvcMapper;
    @Override
    public Item findById(int id) {
        return testMvcMapper.findById(id);
    }
}
