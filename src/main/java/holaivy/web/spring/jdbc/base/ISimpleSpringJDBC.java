package holaivy.web.spring.jdbc.base;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

@SuppressWarnings("deprecation")
public interface ISimpleSpringJDBC {
	public abstract JdbcTemplate getJdbcTemplate();

	public abstract NamedParameterJdbcTemplate getNamedParameterJdbcTemplate();

	public abstract SimpleJdbcTemplate getSimpleJdbcTemplate();
}