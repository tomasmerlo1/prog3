package personajes;

public class Elfo extends Personaje {

    public Elfo(String nombre, String apodo, String fechaNacimiento, int edad,
                int salud, int velocidad, int destreza, int fuerza,
                int nivel, int armadura) {
        super(nombre, apodo, "Elfo", fechaNacimiento, edad, salud, velocidad, destreza, fuerza, nivel, armadura);
    }

    @Override
    public double calcularDanio(Personaje defensor) {
        double poderDisparo = getDestreza() * getFuerza() * getNivel();
        double efectividad = Math.random() * 100 + 1;
        double valorAtaque = poderDisparo * (efectividad / 100);
        double poderDefensa = defensor.getArmadura() * defensor.getVelocidad();
        double danio = ((valorAtaque - poderDefensa) / 500) * 100 * 1.05;

        return Math.max(danio, 0);
    }
}
