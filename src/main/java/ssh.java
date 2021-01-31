import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class ssh {

    public static void main(String args[]) {
        String user = "admin";
        String password = "Password10";
        String host = "192.168.0.108";
        int port = 22;

        Session session = null;
        try {
            JSch jsch = new JSch();
            session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            System.out.println("Establishing Connection...");
            session.connect();
            System.out.println("Connection established.");
            System.out.println("Crating SFTP Channel.");
            ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
            sftpChannel.connect();
            System.out.println("SFTP Channel created.");

            String re = sftpChannel.getHome();

            System.out.println(re);

        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        }finally {
            if(session != null)
            session.disconnect();
        }
    }
}
