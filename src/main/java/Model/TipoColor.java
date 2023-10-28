package Model;

public enum TipoColor {
    AZUL(1),
    VERDE(2),
    AMARILLO(3),
    NARANJA(4),
    ROJO(5);

    private final Integer point;

    TipoColor(Integer a) {
        this.point = a;
    }

    /**
     *
     * @return
     */
    public Integer getValorNumerico() {
        return this.point;
    }
}
