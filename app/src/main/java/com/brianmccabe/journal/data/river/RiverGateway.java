package com.brianmccabe.journal.data.river;

/**
 * Created by brianmccabe on 02/02/2018.
 */

public interface RiverGateway {
  void loadJournalRivers(RiversGatewayCallback.OnGetJournalRivers journalRivers);
  void loadGoogleRivers(RiversGatewayCallback.OnGetGoogleRivers googleRivers);
}
