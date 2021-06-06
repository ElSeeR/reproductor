package paquete;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class LectorCanciones
{
    public ArrayList<Track> readTracks(String folder, final String suffix)
    {
        File audioFolder = new File(folder);
        ArrayList<Track> tracks = new ArrayList<Track>();
        File[] audioFiles = audioFolder.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name)
            {
                return name.toLowerCase().endsWith(suffix);
            }
        });
        
        for(File file : audioFiles) {
            Track trackDetails = detalles(file);
            tracks.add(trackDetails);
        }
        return tracks;
    }

    private Track detalles(File file)   {
        String artista = "desconocido";
        String genero = "desconocido";
        String nombre = file.getPath();
        
        String details = nombre;
        String[] parts = details.split("\\.");
        
        
        
        String simbolo = "\\";
        parts = parts[0].split("\\" + simbolo);
        
        
        if (parts.length >= 1) {
        	parts = parts[1].split("-");
	        artista = parts[0];
	        nombre = parts[1];
	        genero = parts[2];
        }
        return new Track(artista, nombre, genero);
    }
    
}
