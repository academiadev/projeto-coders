package br.com.academiadev.projetocoders.reembolsocoders.config.jwt;

import java.util.Date;

import br.com.academiadev.projetocoders.reembolsocoders.common.TimeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AbstractTokenUtils {

	@Value("${app.name}")
	protected String APP_NAME;

	@Value("${jwt.secret}")
	public String SECRET;

	@Value("${jwt.expires_in}")
	protected int EXPIRES_IN;

	@Value("${jwt.mobile_expires_in}")
	protected int MOBILE_EXPIRES_IN;

	@Value("${jwt.header}")
	protected String AUTH_HEADER;

	@Autowired
	protected TimeProvider timeProvider;

	protected SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

	public AbstractTokenUtils() {
		super();
	}

	protected String generateAudience(Device device) {
		TipoDispositivo audience = TipoDispositivo.AUDIENCE_UNKNOWN;
		if (device.isNormal()) {
			audience = TipoDispositivo.AUDIENCE_WEB;
		} else if (device.isTablet()) {
			audience = TipoDispositivo.AUDIENCE_TABLET;
		} else if (device.isMobile()) {
			audience = TipoDispositivo.AUDIENCE_MOBILE;
		}
		return audience.getId();
	}

	protected Claims getAllClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	protected Date generateExpirationDate(Device device) {
		long expiresIn = device.isTablet() || device.isMobile() ? MOBILE_EXPIRES_IN : EXPIRES_IN;
		return new Date(timeProvider.getDataAtual().getTime() + expiresIn * 1000);
	}

	protected Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
		return (lastPasswordReset != null && created.before(lastPasswordReset));
	}

}