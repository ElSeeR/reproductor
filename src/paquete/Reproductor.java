package paquete;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.advanced.AdvancedPlayer;


public class Reproductor
{
    private AdvancedPlayer player;
    
    public Reproductor()
    {
        player = null;
    }
    
    public void reproducir(final String nombre)
    {
        try {
            setupPlayer(nombre);
            Thread playerThread = new Thread() {
                public void run()
                {
                    try {
                        player.play();
                    }
                    catch(JavaLayerException e) {
                        reportProblem(nombre);
                    }
                    finally {
                        killPlayer();
                    }
                }
            };
            playerThread.start();
        }
        catch (Exception ex) {
            reportProblem(nombre);
        }
    }
    
    public void stop()
    {
        killPlayer();
    }
    
    private void setupPlayer(String nombre)
    {
        try {
            InputStream is = getInputStream(nombre);
            player = new AdvancedPlayer(is, createAudioDevice());
        }
        catch (IOException e) {
            reportProblem(nombre);
            killPlayer();
        }
        catch(JavaLayerException e) {
            reportProblem(nombre);
            killPlayer();
        }
    }

    private InputStream getInputStream(String nombre)
        throws IOException
    {
        return new BufferedInputStream(
                    new FileInputStream(nombre));
    }

    private AudioDevice createAudioDevice()
        throws JavaLayerException
    {
        return FactoryRegistry.systemRegistry().createAudioDevice();
    }

    private void killPlayer()
    {
        synchronized(this) {
            if(player != null) {
                player.stop();
                player = null;
            }
        }
    }
    
    private void reportProblem(String nombre)
    {
        System.out.println("Hubo un problema con la canción: " + nombre);
    }

}
