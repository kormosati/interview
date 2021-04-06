package hu.heitec.interview.chardonnay.spring;

public class HelloServiceImpl implements HelloService {

	@Override
	public String hello() {
		return "Hello Heitec!";
	}

}
