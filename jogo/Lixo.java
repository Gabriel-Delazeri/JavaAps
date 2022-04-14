package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Lixo {

    private Image imagem;
    private int x, y;
    private int largura, altura;
    private boolean isVisivel;

    private static final int LARGURA_TELA = 500;
    private static int velocidade;

    private int gerador;

    private static int contador = 0;

    public Lixo(int x, int y){

        ImageIcon referencia;
        Random random = new Random();
        gerador = random.nextInt(3);

        if(gerador == 1){
            referencia = new ImageIcon("res//lixo_1.png");
        }else{
            referencia = new ImageIcon("res//lixo_2.png");
        }
        imagem = referencia.getImage();

        velocidade = 1;

        this.x = x;
        this.y = y;

        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);

        isVisivel = true;
    }

    public void mexer(){

        if(this.x < 0){
            this.x = LARGURA_TELA;
        } else {
            this.x -= velocidade;
        }
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel){
        this.isVisivel = isVisivel;
    }

    public Image getImagem() {
        return imagem;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    // tratar colisão vida etc
    public Rectangle getBounds(){
        return new Rectangle(x, y, largura, altura);
    }
        
}
