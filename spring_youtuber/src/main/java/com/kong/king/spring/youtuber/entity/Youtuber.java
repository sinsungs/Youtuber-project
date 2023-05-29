package com.kong.king.spring.youtuber.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")
public class Youtuber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long yno;
	private String name;
	private String title;
	private String content;	
	private int likes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Member writer;  // Member와 연관관계 지정
	
//	@OneToMany(mappedBy = "youtuber")
//	private List<PostYoutuber> postYoutubers;
	
    @OneToMany(mappedBy = "youtuber")
    private Set<PostYoutuber> postYoutubers = new HashSet<>();
	
	public void changeTitle(String title) {
		this.title = title;
	}
	
	public void changeContent(String content) {
		this.content = content;
		
		
	}
}

