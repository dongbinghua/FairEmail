package eu.faircode.email;

/*
    This file is part of FairEmail.

    FairEmail is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    FairEmail is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with FairEmail.  If not, see <http://www.gnu.org/licenses/>.

    Copyright 2018-2019 by Marcel Bokhorst (M66B)
*/

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoRuleLog {
    @Query("SELECT rule_log.*, message.account, message.thread, message.subject FROM rule_log" +
            " JOIN message ON message.id = rule_log.message" +
            " WHERE rule = :rule" +
            " ORDER by rule_log.time")
    LiveData<List<TupleRuleLogEx>> liveRuleLogs(long rule);

    @Insert
    long insertRuleLog(EntityRuleLog log);
}
