import com.xls.pojo.Dept;
import com.xls.pojo.Emp;
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
import java.util.Map;
import java.util.Set;

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
    public void testFindOne(){
        //查询单个对象
        List<Emp> list = sqlSession.selectList("findOne");
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    @Test
    public void testFindList(){
        //查询所有对象
        List<Emp> list = sqlSession.selectList("Emp.findAll");
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    @Test
    public void testFindMap(){
        //查询所有对象,前一个emp映射id，后一个参数是emp表的字段名，得大写
        Map<Integer,Emp> empMap = sqlSession.selectMap("findEmpMap","EMPNO");
        Set<Integer> empnos = empMap.keySet();
        for (Integer empno : empnos) {
            System.out.println(empno+" :" +empMap.get(empno));
        }

    }

    @After
    public void release(){
        // 关闭SQLSession
        sqlSession.close();
    }
}
