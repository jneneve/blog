package com.example.blog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryMemory implements PostRepository {

	List<Post> postsGroup = new ArrayList<Post>();

	@Override
	public void save(Post post) {
		postsGroup.add(post);
	}

	@Override
	public Post getById(String postId) {
		for (Post post : postsGroup) {
			if (post.getPostId().toString().equals(postId)) {
				return Post.restore(post.getPostId(), post.getTitle(), post.getContent(), post.getTimestamp());
			}
		}
		return null;
	}
}
