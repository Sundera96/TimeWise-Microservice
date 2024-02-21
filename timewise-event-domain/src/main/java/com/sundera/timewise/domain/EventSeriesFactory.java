package com.sundera.timewise.domain;

import org.springframework.stereotype.Component;

@Component
public class EventSeriesFactory implements IEventSeriesFactory {

	@Override
	public EventSeries createEventSeries() {
		return new EventSeries();
	}

}
