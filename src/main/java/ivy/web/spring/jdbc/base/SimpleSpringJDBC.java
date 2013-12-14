package ivy.web.spring.jdbc.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * A Simple Spring JDBC Base Bean
 * 
 * @author holaivy@gmail.com
 * 
 */
@SuppressWarnings("deprecation")
public class SimpleSpringJDBC implements ISimpleSpringJDBC {

	@Autowired
	@Qualifier("inSpringJDBCTemplate")
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("inSimpleSpringJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	@Autowired
	@Qualifier("inNamedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	@Deprecated
	public SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}

	@Override
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

}
