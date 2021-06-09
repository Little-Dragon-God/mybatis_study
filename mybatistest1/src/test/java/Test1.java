import com.xls.pojo.Dept;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.security.util.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {
    private SqlSession sqlSession;
    @Before
    public void init(){
        SqlSessionFactoryBuilder ssfb =new SqlSessionFactoryBuilder();
        InputStream is = this.getClass().getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory=ssfb.build(is) ;
        sqlSession=factory.openSession();
    }

    @Test
    public void testFindAll(){

        // 调用SQL语句
        List<Dept> list = sqlSession.selectList("findAll");
        for (Dept dept : list) {
            System.out.println(dept);
        }

    }

    @After
    public void release(){
        // 关闭SQLSession
        sqlSession.close();
    }
}
