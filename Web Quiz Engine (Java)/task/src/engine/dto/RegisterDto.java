package engine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {

    @Email(message = "Invalid email format")
    @Pattern(regexp = "^[a-z]+@[a-z]+\\.[a-z]+", message = "Invalid email format")
    private String email;

    @Size(min = 5, message = "Password must be at least 5 characters long")
    private String password;
}
