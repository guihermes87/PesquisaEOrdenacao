namespace Model;

public class Processo
{
    public int Id { get; set; }
    public DateTime Data { get; set; }

    public Processo(int id, DateTime data)
    {
        Id = id;
        Data = data;
    }
}