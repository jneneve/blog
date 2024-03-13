package com.example.blog;

import java.util.ArrayList;
import java.util.List;

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
