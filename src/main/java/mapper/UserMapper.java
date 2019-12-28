package mapper;



import com.car.asistant.demo.dto.UserDto;
import com.car.asistant.demo.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userEntityToUserDto(UserEntity userEntity);
    UserEntity userDtoToUserEntity(UserDto userDto);

}
