package Abstract;

public interface IEntity {
	
	//Somut classlar herhangi bir class'ý extend veya herhangi bir interface'i implemente etmiyorsa eðer ileride karþýmýza nesnel zaafiyetler
		//çýkacaktýr. Þu an için bu interface kullanýlmýyor gibi gözüküyor ama aslýda Customer class'ý bu interface'i implemente ediyor. Ýleride
		//müþteri benzeri baþka veri içeren classlar eklendiðinde sisteme, musteri IEntity interface'ini implemente edecekler ve musteri classlarýmýzý 
		//nesnel zaafiyetden kurtaracaklar. (Þu an buna ihtiyac yok gibi gozukuyor ama ileriye donuk kodu nesnel zaafiyetlerden kurtarmak için 
		//yapýlmýþ bir hareket.)

}
