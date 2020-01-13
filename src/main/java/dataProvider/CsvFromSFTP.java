package dataProvider;

import org.testng.annotations.Test;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class CsvFromSFTP {

    private String remoteHost = "ci-cd-vm.canadacentral.cloudapp.azure.com";
    private String username = "bmw-int";
    private String password = "BmW@Int";
    private String remoteFile = "/BMW-INT/Prahlad_Automation/vins_2019_10_07.csv";
    private String localFile = "C:/Download/vins.csv";

    @Test
    public void whenDownloadFileUsingJsch_thenSuccess() throws JSchException, SftpException {
        ChannelSftp channelSftp = setupJsch();
        channelSftp.connect();
        System.out.println("Connected");
        channelSftp.get(remoteFile, localFile);
        System.out.println("download");
        channelSftp.exit();
    }

    private ChannelSftp setupJsch() throws JSchException {
        JSch jsch = new JSch();
        // jsch.setKnownHosts(knownHostsFileLoc);
        Session jschSession = jsch.getSession(username, remoteHost);
        jschSession.setPassword(password);
        jschSession.setConfig("StrictHostKeyChecking", "no");
        jschSession.connect();
        System.out.println("connected");
        return (ChannelSftp) jschSession.openChannel("sftp");
    }
}