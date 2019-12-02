package com.octo.domain.video;

import com.octo.domain.enums.Level;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Video {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String url;
	@Column
	private Double duration;
	@Enumerated(EnumType.STRING)
	@Column
	private Level level;
	@ElementCollection
	private List<String> tags = new ArrayList<>();

	public boolean isOneTagIsPresent(List<String> listtags) {
		for (String tag : tags) {
			if (listtags.contains(tag))
				return true;
		}
		return false;
	}

	public boolean filterByLevel(Level level1) {
		return level != null ? level.equals(level1) : false;
	}

}
