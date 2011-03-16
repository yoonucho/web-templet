package com.hw.shop.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONSerializer;

import org.springframework.web.servlet.view.AbstractView;

public class JsonView extends AbstractView {
	public JsonView() {
		super();
		setContentType("text/json; charset=utf-8");
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(Map model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType(getContentType());
		response.getWriter().write(
				JSONSerializer.toJSON(model.get("map")).toString());
	}

}