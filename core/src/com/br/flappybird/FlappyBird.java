package com.br.flappybird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.xml.soap.Text;

public class FlappyBird extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture[] passaros;
	private Texture fundo;

	//Atributos de configuração
	private int alturaDispositivo;
	private int larguraDispositivo;
	private int centroVertical;
	private int centroHorizontal;
	private float variacao = 0;
	private int velocidadeQueda=0;
	private int posicaoInicialVertical;


	@Override
	public void create () {
		batch = new SpriteBatch();
		passaros = new Texture[3];
		passaros[0] = new Texture("passaro1.png");
		passaros[1] = new Texture("passaro2.png");
		passaros[2] = new Texture("passaro3.png");

		fundo = new Texture("fundo.png");

		alturaDispositivo = Gdx.graphics.getHeight();
		larguraDispositivo = Gdx.graphics.getWidth();

		centroVertical =   Gdx.graphics.getHeight()/2;
		centroHorizontal = Gdx.graphics.getWidth()/2;
		posicaoInicialVertical = centroVertical;

	}

	@Override
	public void render () {
		variacao += Gdx.graphics.getDeltaTime() * 5;
		velocidadeQueda++;

		if (variacao > 2){
			variacao = 0;
		}

		if(Gdx.input.justTouched()){
			velocidadeQueda = -15;
		}

		if (posicaoInicialVertical > 0 || velocidadeQueda < 0) {
			posicaoInicialVertical = posicaoInicialVertical - velocidadeQueda;
		}

		batch.begin();
		batch.draw(fundo,0,0,larguraDispositivo,alturaDispositivo);
		batch.draw(passaros [(int) variacao],30,posicaoInicialVertical);
		batch.end();



	}


}
