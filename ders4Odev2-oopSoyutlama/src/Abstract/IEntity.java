package Abstract;

public interface IEntity {
	
	//Somut classlar herhangi bir class'� extend veya herhangi bir interface'i implemente etmiyorsa e�er ileride kar��m�za nesnel zaafiyetler
		//��kacakt�r. �u an i�in bu interface kullan�lm�yor gibi g�z�k�yor ama asl�da Customer class'� bu interface'i implemente ediyor. �leride
		//m��teri benzeri ba�ka veri i�eren classlar eklendi�inde sisteme, musteri IEntity interface'ini implemente edecekler ve musteri classlar�m�z� 
		//nesnel zaafiyetden kurtaracaklar. (�u an buna ihtiyac yok gibi gozukuyor ama ileriye donuk kodu nesnel zaafiyetlerden kurtarmak i�in 
		//yap�lm�� bir hareket.)

}
