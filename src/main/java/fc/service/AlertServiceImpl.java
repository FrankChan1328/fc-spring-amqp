package fc.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import fc.domain.Spittle;

public class AlertServiceImpl implements AlertService {

	private RabbitTemplate rabbit;

	@Autowired
	public AlertServiceImpl(RabbitTemplate rabbit) {
		this.rabbit = rabbit;
	}

	public void sendSpittleAlert(Spittle spittle) {
		rabbit.convertAndSend("spittle.alert.exchange", "spittle.alerts", spittle);
	}

}
