package com.sundera.timewise.event.dto;

import java.util.List;
import com.sundera.timewise.import_events.IEventImporter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LinkEventDto extends EventDto{

	private String link;

	@Override
	public <T> List<T> eventImporter(IEventImporter<T> visitor) {
		return visitor.importLinkEvent(getEventId(),getUserId(), getTitle(), getTopic(), getNotes(), getPriority(), getCreatedDateTime(), getExpiryDateTime(), getLink());
	}
}
