package alchemystar.freedom.test;

import org.junit.Before;

import alchemystar.freedom.sql.SqlExecutor;
import alchemystar.freedom.test.bptest.BasicGenTable;

/**
 * @Author lizhuyang
 */
public class BasicSelectTest extends BasicGenTable {

    public static final String insertSqlTemplate = "insert into test (id,name) values (?,?)";

    @Before
    public void init() {
        SqlExecutor executor = new SqlExecutor();
        executor.execute(CreateTest.CREATE_SQL, null);
        insertSome();
    }

    private void insertSome() {
        for (int i = 0; i < 1000; i++) {
            String insertSql =
                    insertSqlTemplate.replaceFirst("\\?", String.valueOf(i)).replaceFirst("\\?", "'alchemystar" +
                            String
                                    .valueOf(i) + "'").replaceFirst("\\?", "'comment" + String.valueOf(i) + "'");
            System.out.println(insertSql);
            SqlExecutor sqlExecutor = new SqlExecutor();
            sqlExecutor.execute(insertSql, null);
        }

        System.out.println("insert okay");
    }

}
