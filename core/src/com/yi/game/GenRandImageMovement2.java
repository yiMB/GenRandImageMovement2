package com.yi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GenRandImageMovement2 extends ApplicationAdapter {
	SpriteBatch batch;
	TextureCookieControl textureCookieControl;

	@Override
	public void create () {
		batch = new SpriteBatch();
		textureCookieControl = new TextureCookieControl();
		textureCookieControl.addNTextureCookie(9);
	}

	@Override
	public void dispose() {
		batch.dispose();
		for(int i=0; i < textureCookieControl.arrTextureCookies.size; i++){
			textureCookieControl.arrTextureCookies.get(i).textureCookie.dispose();
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		for(TextureCookie textureCookie : textureCookieControl.arrTextureCookies){
			batch.draw(textureCookie.textureCookie, textureCookie.rectCookieBorder.x, textureCookie.rectCookieBorder.y,
					textureCookie.rectCookieBorder.width, textureCookie.rectCookieBorder.height);
		}

		batch.end();
		textureCookieControl.update();
	}
}
