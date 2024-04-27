package med.hia.api.Controller;

import jakarta.validation.Valid;
import med.hia.api.dto.User.AuthDataDTO;
import med.hia.api.dto.User.UserTokenDTO;
import med.hia.api.infra.security.TokenService;
import med.hia.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;

   
    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthDataDTO data){

        var authToken= new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth= manager.authenticate(authToken);
        var tokenJWT= tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new UserTokenDTO(tokenJWT));

    }
}
