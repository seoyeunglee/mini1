package minip.mapper;

import org.apache.ibatis.annotations.Param;

public interface LoginMapper {
	public Integer idCheckSelectOne(@Param("userId") String userId);

}
