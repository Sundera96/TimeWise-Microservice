package com.sundera.timewise.domain;

import com.sundera.timewise.export_events.IEventExporter;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LinkEvent extends Event {
	
	@NotNull
	private String link;

	@Override
	public <T> T export(IEventExporter<T> visitor) {
		return visitor.exportLinkEvent(getId(),getUserId(), getTitle(), getTopic(), getNotes(), getPriority(), getCreatedDateTime(), getExpiryDateTime(), getEventDateTime(), getLink());
	}

}
