package br.com.leodevel.quarkusbasicproject.services;

import java.util.UUID;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.Claims;
import org.jboss.logmanager.Logger;
import org.jose4j.jwt.JwtClaims;

import br.com.leodevel.quarkusbasicproject.models.User;
import br.com.leodevel.quarkusbasicproject.utils.TokenUtils;

@RequestScoped
public class TokenService {

	public final static Logger LOGGER = Logger.getLogger(TokenService.class.getSimpleName());

	@ConfigProperty(name = "jwt.expiration-in-min")
	int jwtExpirationInMin;
	
	@ConfigProperty(name = "mp.jwt.verify.issuer")
	String issuer;
	
    public String generateToken(User user) {
        
    	try {

        	JwtClaims jwtClaims = new JwtClaims();
            jwtClaims.setIssuer(issuer);
            jwtClaims.setJwtId(UUID.randomUUID().toString());
            jwtClaims.setSubject(user.getUsername());
            jwtClaims.setClaim(Claims.upn.name(), user.getUsername());
            jwtClaims.setClaim(Claims.preferred_username.name(), user.getUsername());
            jwtClaims.setClaim(Claims.groups.name(), user.getRoles().stream().map(obj -> obj.getRole().name()).collect(Collectors.toList()));
            jwtClaims.setExpirationTimeMinutesInTheFuture(jwtExpirationInMin);

            String token = TokenUtils.generateTokenString(jwtClaims);
            
            return token;
        
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
	
}
