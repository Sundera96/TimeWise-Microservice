package com.sundera.timewise.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.sundera.timewise.export_events.IEventExporter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="event",indexes = {
		@Index(columnList = "userId")
})
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Event.findEvent",
query="select e from Event e  where e.deletedDateTime is null and e.userId =?1 and e.id = ?2")
@NamedQuery(name = "Event.findEventsBetweenDates",
query="select e from Event e where e.deletedDateTime is null and e.userId =?1 and e.eventDateTime between ?2 and ?3")
public abstract class Event {
	
	@Id 
	@GeneratedValue
	private UUID id;

	@NotNull
	private String userId;
	
	@NotNull
	private String title;
	
	@NotNull
	private String topic;
	
	private String notes;
	
	@Min(value = 1)
	@Max(value = 3)
	private int priority=1;
	
	@CreationTimestamp
	private LocalDateTime createdDateTime;
	
	private LocalDateTime expiryDateTime;
	
	@ManyToOne
	@JoinColumn(name="series_id")
	private EventSeries series;
	
	@NotNull
	private LocalDateTime eventDateTime;
	
	private LocalDateTime deletedDateTime;

	public abstract <T> T export (IEventExporter<T> visitor);
}

