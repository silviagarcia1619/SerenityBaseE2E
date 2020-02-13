package co.com.nombreproyecto.data;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:data.properties"})

public interface Environment extends Config {

  String urlUsersPage2();
  String urlUsers();
  String urlJsonTest();
  String urlIexTopLast();
  String urlIexStatsRecords();


}


