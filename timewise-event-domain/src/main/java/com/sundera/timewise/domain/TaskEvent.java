package com.sundera.timewise.domain;

import com.sundera.timewise.export_events.IEventExporter;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TaskEvent extends Event {
	private boolean formHabit;
	
	@Override
	public <T> T export(IEventExporter<T> visitor) {
		return visitor.exportTaskEvent(getId(), getUserId(), getTitle(), getTopic(), getNotes(), getPriority(), getCreatedDateTime(), getExpiryDateTime(), getEventDateTime(), formHabit);
	}
}
