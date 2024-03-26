package com.example.blog.adapter.out.persistence.memory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.blog.application.domain.Post;
import com.example.blog.application.port.out.PostRepository;

@Repository
public class PostRepositoryMemory implements PostRepository {

	List<Post> posts = new ArrayList<Post>();

	@Override
	public void save(Post post) {
		posts.add(post);
	}

	@Override
	public Post getById(String postId) {
		for (Post post : posts) {
			if (post.getPostId().toString().equals(postId)) {
				return Post.restore(post.getPostId(), post.getTitle(), post.getContent(), post.getTimestamp());
			}
		}
		return null;
	}
}
