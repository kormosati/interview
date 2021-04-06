package hu.heitec.interview.malbec.spring;

import org.springframework.stereotype.Service;

@Service
public class PingService implements NetworkService {

	@Override
	public String connect() {
		return "ping";
	}

}
