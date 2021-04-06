package hu.heitec.interview.malbec.spring;

import org.springframework.stereotype.Service;

@Service
public class PongService implements NetworkService {

	@Override
	public String connect() {
		return "pong";
	}

}
