package com.example.blog;

import java.util.List;

public interface GetCommentsUseCase {

	public List<CommentOutputDTO> execute(String postId);
}
