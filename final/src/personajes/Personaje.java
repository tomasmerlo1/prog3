package personajes;

public abstract class Personaje { protected String nombre;
    protected String apodo;
    protected String raza;
    protected String fechaNacimiento;
    protected int edad;
    protected int salud;
    protected int velocidad;
    protected int destreza;
    protected int fuerza;
    protected int nivel;
    protected int armadura;

    public Personaje(String nombre, String apodo, String raza, String fechaNacimiento,
                     int edad, int salud, int velocidad, int destreza,
                     int fuerza, int nivel, int armadura) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
        this.salud = salud;
        this.velocidad = velocidad;
        this.destreza = destreza;
        this.fuerza = fuerza;
        this.nivel = nivel;
        this.armadura = armadura;
    }

    public abstract double calcularDanio(Personaje defensor);

    public void recibirDanio(double danio) {
        this.salud -= (int) danio;
        if (salud < 0) salud = 0;
    }

    public boolean estaVivo() {
        return salud > 0;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public String getApodo() { return apodo; }
    public String getRaza() { return raza; }
    public int getSalud() { return salud; }
    public int getVelocidad() { return velocidad; }
    public int getDestreza() { return destreza; }
    public int getFuerza() { return fuerza; }
    public int getNivel() { return nivel; }
    public int getArmadura() { return armadura; }

    public void setSalud(int salud) { this.salud = salud; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    @Override
    public String toString() {
        return String.format("Nombre: %s (%s), Raza: %s, Salud: %d, Velocidad: %d, Destreza: %d, Fuerza: %d, Nivel: %d, Armadura: %d",
                nombre, apodo, raza, salud, velocidad, destreza, fuerza, nivel, armadura);
    }
}

